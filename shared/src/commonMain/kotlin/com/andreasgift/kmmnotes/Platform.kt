package com.andreasgift.kmmnotes

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform