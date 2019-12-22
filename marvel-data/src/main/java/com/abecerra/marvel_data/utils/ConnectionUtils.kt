package com.abecerra.marvel_data.utils

import java.net.InetAddress

fun isInternetAvailable(): Boolean {
    return try {
        val ipAddr = InetAddress.getByName("google.com")
        //You can replace it with your name
        !ipAddr.equals("")

    } catch (e: Exception) {
        false
    }

}