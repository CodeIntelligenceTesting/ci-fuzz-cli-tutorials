package com.example

fun main(args: Array<String>) {
    println("Hello World!")
    val ex = ExploreMe(1)
    ex.exploreMe(1, "A")
    ex.exploreMe(2147483647, "A")
    ex.exploreMe(2000000123, "A")
    ex.exploreMe(2000000123, "FUZZING")
}
