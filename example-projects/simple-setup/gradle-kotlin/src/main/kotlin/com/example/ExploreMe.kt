package com.example

class ExploreMe(private val a: Int) {
    // Function with multiple paths that can be discovered by a fuzzer.
    fun exploreMe(b: Int, c: String) {
        if (a >= 20000) {
            if (b >= 2000000) {
                if (b - a < 100000) {
                    // Trigger Remote Code Execution Bug
                    if (c.startsWith("@")) {
                        val className = c.substring(1)
                        try {
                            Class.forName(className).getDeclaredConstructor().newInstance()
                        } catch (ex: Exception) {
                            when(ex) {
                                is ReflectiveOperationException -> {
                                    // ignore
                                }
                                else -> throw ex
                            }
                        }
                    }
                }
            }
        }
    }
}
