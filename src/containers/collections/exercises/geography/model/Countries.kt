package containers.collections.exercises.geography.model

import containers.collections.exercises.geography.model.Region.*

object Countries {

    val SPAIN = buildCountry("ESP") {
        name = "España"
        region = SOUTHERN_EUROPE
        surface { 505_935.km2 }
        population = 47_519_628
        capital {
            name = "Madrid"
            population = 3_339_931
        }
    }

    val RUSSIA = buildCountry("RUS") {
        name = "Rusia"
        region = EASTER_EUROPE
        surface = 17_098_250.km2
        population = 144_444_359
        capital {
            name = "Moscú"
            population = 10_450_109
        }
    }

    val PORTUGAL = buildCountry("POR") {
        name = "Portugal"
        region = SOUTHERN_EUROPE
        capital {
            name = "Lisboa"
            population = 537_616
        }
        surface = 92_226.km2
        population = 10_247_605
    }

    val ITALY = buildCountry("ITA", "Italy") {
        region = SOUTHERN_EUROPE
        area { value = 301_340 }
        population = 58_870_763
        capital {
            name = "Roma"
            population = 2_303_894
        }
    }

    val GERMANY = buildCountry("GER") {
        name = "Alemania"
        region = WESTERN_EUROPE
        area { value = 357_580 }
        surface { 357_580.km2 }
        population = 83_294_633
        capital {
            name = "Berlín"
            population = 3_456_559
        }
    }


    val CANADA = buildCountry("CAN", "Canada") {
        region = NORTH_AMERICA
        capital {
            name = "Ottawa"
            population = 853_920
        }
        area { value = 9_984_670 }
        population = 38_781_292
    }

    val CHINA = buildCountry("CHN", "China") {
        region = EAST_ASIA
        capital {
            name = "Pekín"
            population = 12_238_285
        }
        area { value = 9_562_910 }
        population = 1_425_671_352
    }


    val NEW_ZEALAND = buildCountry("NZL", "Nueva Zelanda") {
        region = AUSTRALIA_NEW_ZEALAND
        area { value = 267_710 }
        population = 5_228_100
        capital {
            name = "Wellington"
            population = 388_124
        }
    }


    val WORLD_COUNTRIES =
        listOf(SPAIN, RUSSIA, CANADA, CHINA, PORTUGAL, ITALY, GERMANY, NEW_ZEALAND)
}