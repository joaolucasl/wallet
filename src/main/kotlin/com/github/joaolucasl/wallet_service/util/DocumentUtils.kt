package com.github.joaolucasl.wallet_service.util

fun validateCpf(value: String): Boolean {
    val numbers = arrayListOf<Int>()

    value.filter { it.isDigit() }.forEach {
        numbers.add(it.toString().toInt())
    }

    if (numbers.size != 11) return false

    (0..9).forEach { n ->
        val digits = arrayListOf<Int>()
        (0..10).forEach { digits.add(n) }
        if (numbers == digits) return false
    }

    val dv1 = ((0..8).sumBy { (it + 1) * numbers[it] }).rem(11).let {
        if (it >= 10) 0 else it
    }

    val dv2 = ((0..8).sumBy { it * numbers[it] }.let { (it + (dv1 * 9)).rem(11) }).let {
        if (it >= 10) 0 else it
    }

    return numbers[9] == dv1 && numbers[10] == dv2
}