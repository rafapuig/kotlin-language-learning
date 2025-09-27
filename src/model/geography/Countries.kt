package model.geography

import model.geography.SIUnit.*
import model.geography.Region.*

object Countries {

    val SPAIN = buildCountry("ESP", "España") {
        region = SOUTHERN_EUROPE
        capital {
            name = "Madrid"
            population = 3_339_931
        }
        surface { value = 505_935 }
        population = 47_519_628
    }


    val RUSSIA = buildCountry("RUS", "Rusia") {
        region = EASTER_EUROPE
        capital {
            name = "Moscú"
            population = 10_450_109
        }
        surface { value = 17_098_250 }
        population = 144_444_359
    }

    val CANADA = buildCountry("CAN", "Canada") {
        region = NORTH_AMERICA
        capital {
            name = "Ottawa"
            population = 853_920
        }
        surface { value = 9_984_670 }
        population = 38_781_292
    }

    val CHINA = buildCountry("CHN", "China") {
        region = EAST_ASIA
        capital {
            name = "Pekín"
            population = 12_238_285
        }
        surface { value = 9_562_910 }
        population = 1_425_671_352
    }


    val PORTUGAL = buildCountry("POR", "Portugal") {
        region = SOUTHERN_EUROPE
        capital {
            name = "Lisboa"
            population = 537_616
        }
        surface { value = 92_226 }
        population = 10_247_605
    }

    val ITALY = buildCountry("ITA", "Italy") {
        region = SOUTHERN_EUROPE
        surface { value = 301_340 }
        population = 58_870_763
        capital {
            name = "Roma"
            population = 2_303_894
        }
    }


    val NEW_ZEALAND = buildCountry("NZL", "Nueva Zelanda") {
        region = AUSTRALIA_NEW_ZEALAND
        surface { value = 267_710 }
        population = 5_228_100
        capital {
            name = "Wellington"
            population = 388_124
        }
    }


    val WORLD_COUNTRIES = listOf(SPAIN, RUSSIA, CANADA, CHINA, PORTUGAL, ITALY, NEW_ZEALAND)
}