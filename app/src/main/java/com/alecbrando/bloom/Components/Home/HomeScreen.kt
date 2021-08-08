package com.alecbrando.bloom.Components.Home

import androidx.compose.foundation.*
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.alecbrando.bloom.PlantTheme
import com.alecbrando.bloom.R
import com.alecbrando.bloom.ui.theme.BloomTheme


@Composable
fun BloomBottomBar() {
    BottomAppBar(
        backgroundColor = MaterialTheme.colors.primary,
        modifier = Modifier.height(56.dp)
    ) {
        ButtonNavButton(
            label = "Home",
            icon = Icons.Default.Home,
            selected = true
        )
        ButtonNavButton(
            label = "Favorites",
            icon = Icons.Default.FavoriteBorder,
            selected = false
        )
        ButtonNavButton(
            label = "Profile",
            icon = Icons.Default.AccountCircle,
            selected = false
        )
        ButtonNavButton(
            label = "Cart",
            icon = Icons.Default.ShoppingCart,
            selected = false
        )
    }
}


@Composable
fun RowScope.ButtonNavButton(
    label: String,
    icon: ImageVector,
    selected: Boolean
) {
    BottomNavigationItem(
        selected = selected,
        onClick = {},
        label = {
            Text(
                text = label
            )
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = label,
                modifier = Modifier.size(24.dp)
            )
        }
    )
}

@Composable
private fun HomeScreenLoader(
    paddingValues: PaddingValues
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .wrapContentSize()
                .align(Alignment.Center)
        )
    }
}

@Composable
fun HomeScreen(
    navController: NavController,
) {
    val viewModel: HomeViewModel = viewModel(factory = ViewModelFactory())

    val plantItems by viewModel.plantThemeItems.observeAsState()
    val gardenItems by viewModel.defaultGardenItems.observeAsState()
    val loadingGardenItems by viewModel.loadingGarden.observeAsState(true)
    val loadingPlantItems by viewModel.loadingPlantThemes.observeAsState(true)

    Scaffold(
        bottomBar = { BloomBottomBar() }
    ) { paddingValues ->
        if (loadingGardenItems && loadingPlantItems) {
            HomeScreenLoader(paddingValues)
        } else {
            HomeScreenContent(
                plantItems!!,
                gardenItems!!,
            )
        }

    }
}


@Composable
fun HomeScreenContent(
    plantItems: List<PlantTheme>,
    gardenItems: List<PlantTheme>
) {
    val rowScrollState = rememberScrollState()
    val columnScrollState = rememberScrollState()
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = {
                    Text(
                        text = "Search",
                        style = MaterialTheme.typography.body1,
                        color = MaterialTheme.colors.onPrimary
                    )
                },
                modifier = Modifier
                    .fillMaxWidth(),
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = null,
                        modifier = Modifier.size(18.dp)
                    )
                }

            )
            Box(
                contentAlignment = Alignment.CenterStart,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = "Browse themes",
                    modifier = Modifier.paddingFromBaseline(top = 32.dp, bottom = 18.dp),
                    style = MaterialTheme.typography.h1,
                    color = MaterialTheme.colors.onPrimary
                )
            }
            ThemeSection(rowScrollState, plantItems)
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .paddingFromBaseline(top = 40.dp)
            ) {
                Text(
                    text = "Design your home garden",
                    style = MaterialTheme.typography.h1,
                    modifier = Modifier
                )

                IconButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(
                        imageVector = Icons.Default.FilterList,
                        contentDescription = null,
                        modifier = Modifier.size(24.dp)
                    )
                }

            }
            HomeGardenSection(columnScrollState, gardenItems)
        }
    }

}

@Composable
private fun HomeGardenSection(columnScrollState: ScrollState, items: List<PlantTheme>) {
    Column(
        modifier = Modifier.verticalScroll(columnScrollState)
    ) {
        items.forEach { gardenItem ->
            Row(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth()
                    .padding(vertical = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {

                Image(
                    painter = painterResource(id = gardenItem.image),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(64.dp)
                        .clip(MaterialTheme.shapes.small),
                )
                Column(
                    modifier = Modifier
                        .weight(.4f)
                        .padding(start = 10.dp)
                ) {
                    Text(
                        text = gardenItem.title,
                        style = MaterialTheme.typography.h2,
                        modifier = Modifier.paddingFromBaseline(top = 24.dp)
                    )
                    Text(
                        text = "This is a description",
                        style = MaterialTheme.typography.body1,
                        modifier = Modifier.paddingFromBaseline(bottom = 24.dp)

                    )
                }
                Checkbox(checked = true, onCheckedChange = {})
            }
        }
    }
}

@Composable
private fun ThemeSection(rowScrollState: ScrollState, items: List<PlantTheme>) {
    Row(
        Modifier
            .horizontalScroll(rowScrollState)
            .height(136.dp)
    ) {
        items.forEach { themeItem ->
            Card(
                modifier = Modifier
                    .size(136.dp)
                    .padding(end = 10.dp),
                shape = MaterialTheme.shapes.small,
                elevation = 1.dp,
                backgroundColor = if (MaterialTheme.colors.isLight) MaterialTheme.colors.background else Color(
                    0xFF393939
                )
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxHeight(),
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        painter = painterResource(id = themeItem.image),
                        contentDescription = null,
                        modifier = Modifier.weight(.8f),
                        contentScale = ContentScale.Crop,
                    )
                    Row(
                        modifier = Modifier
                            .weight(.2f)
                            .fillMaxWidth()
                            .padding(start = 5.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            text = themeItem.title,
                            style = MaterialTheme.typography.h2,
                            color = MaterialTheme.colors.onPrimary
                        )
                    }
                }

            }
        }
    }
}

