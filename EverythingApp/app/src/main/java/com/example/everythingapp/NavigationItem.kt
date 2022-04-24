package com.example.everythingapp

sealed class NavigationItem(var count: String, var icon: Int, var title: String){
    object Home: NavigationItem("home", R.drawable.ic_launcher_background, "Home")
    object Music: NavigationItem("music", R.drawable.ic_launcher_background, "Music")
    object Home: NavigationItem("home", R.drawable.ic_launcher_background, "Home")
}
