package com.example.tp2.controller

import java.util.Calendar

class AgeCalculator {
    companion object {
        fun calculateAge(birthdate: String): Int {
            val currentYear = Calendar.getInstance().get(Calendar.YEAR)
            return currentYear - birthdate.toInt()
        }
    }
}