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

    val ITALY = buildCountry("ITA", "Italia") {
        region = SOUTHERN_EUROPE
        surface = 301_340.km2
        population = 58_870_763
        capital {
            name = "Roma"
            population = 2_303_894
        }
    }

    val GERMANY = buildCountry("GER") {
        name = "Alemania"
        region = WESTERN_EUROPE
        surface { 357_580.km2 }
        population = 83_294_633
        capital {
            name = "Berlín"
            population = 3_456_559
        }
    }

    val FRANCE = buildCountry("FRA") {
        name = "Francia"
        region = WESTERN_EUROPE
        surface = 549_087.km2
        population = 64_756_584
        capital {
            name = "Paris"
            population = 2_103_085
        }
    }

    val UK = buildCountry("GBR") {
        name = "Reino Unido"
        region = NORTHERN_EUROPE
        surface = 243_610.km2
        population = 67_736_802
        capital {
            name = "Londres"
            population = 7_840_009
        }
    }

    val IRELAND = buildCountry("IRL") {
        name = "Irlanda"
        region = NORTHERN_EUROPE
        surface = 70_280.km2
        population = 5_056_935
        capital {
            name = "Dublín"
            population = 551_768
        }
    }

    val CANADA = buildCountry("CAN", "Canada") {
        region = NORTH_AMERICA
        surface = 9_984_670.km2
        population = 38_781_292
        capital {
            name = "Ottawa"
            population = 853_920
        }
    }

    val USA = buildCountry("USA") {
        name = "Estados Unidos de America"
        region = NORTH_AMERICA
        surface = 9_831_510.km2
        population = 339_996_564
        capital {
            name = "Washington, D.C."
            population = 622_079
        }
    }

    val MEXICO = buildCountry("MEX") {
        name = "Mexico"
        region = NORTH_AMERICA
        surface = 1_964_375.km2
        population = 128_455_567
        capital {
            name = "Ciudad de Mexico"
            population = 13_042_337
        }
    }

    val ARGENTINA = buildCountry("ARG") {
        name = "Argentina"
        region = SOUTH_AMERICA
        surface = 2_780_400.km2
        population = 45_773_884
        capital {
            name = "Buenos Aires"
            population = 13_735_799
        }
    }

    val BRAZIL = buildCountry("BRA") {
        name = "Brasil"
        region = SOUTH_AMERICA
        surface = 8_515_770.km2
        population = 216_422_446
        capital {
            name = "Brasilia"
            population = 2_294_077
        }
    }

    val VENEZUELA = buildCountry("VEN", "Venezuela") {
        region = SOUTH_AMERICA
        surface = 912_050.km2
        population = 28_838_499
        capital {
            name = "Caracas"
        }
    }

    val COLOMBIA = buildCountry("COL") {
        name = "Colombia"
        region = SOUTH_AMERICA
        surface = 1_141_749.km2
        population = 52_085_168
        capital {
            name = "Bogotá"
            population = 7_135_912
        }
    }


    val CHINA = buildCountry("CHN", "China") {
        region = EAST_ASIA
        capital {
            name = "Pekín"
            population = 12_238_285
        }
        surface = 9_562_910.km2
        population = 1_425_671_352
    }

    val JAPAN = buildCountry("JPN", "Japan") {
        region = EAST_ASIA
        surface = 377_970.km2
        population = 123_294_513
        capital {
            name = "Tokio"
            population = 8_211_601
        }
    }

    val INDIA = buildCountry("IND", "India") {
        region = SOUTHEAST_ASIA
        surface = 3_287_259.km2
        population = 1_428_627_663
        capital {
            name = "Nueva Delhi"
            population = 336_059
        }
    }

    val INDONESIA = buildCountry("IDN", "Indonesia") {
        region = SOUTHEAST_ASIA
        surface = 1_913_580.km2
        population = 277_534_123
        capital {
            name = "Jakarta"
            population = 9_063_304
        }
    }

    val BANGLADESH = buildCountry("BGD") {
        name = "Bangladesh"
        region = SOUTH_ASIA
        surface = 147_630.km2
        population = 172_954_319
        capital {
            name = "Daca"
            population = 10_955_651
        }
    }

    val TURKEY = buildCountry("TUR") {
        name = "Turquía"
        region = WESTERN_ASIA
        surface = 785_350.km2
        population = 85_816_199
        capital {
            name = "Ankara"
            population = 3_685_432
        }
    }

    val MOROCCO = buildCountry("MAR") {
        name = "Marruecos"
        region = NORTHERN_AFRICA
        surface = 710_850.km2
        population = 37_840_044
        capital {
            name = "Rabat"
            population = 618_065
        }
    }

    val NIGERIA = buildCountry("NGA", "Nigeria") {
        region = WESTERN_AFRICA
        surface = 923_770.km2
        population = 223_804_632
        capital {
            name = "Abuja"
            population = 683_636
        }
    }

    val EGYPT = buildCountry("EGY") {
        name = "Egipto"
        region = NORTHERN_AFRICA
        surface = 1_001_450.km2
        population = 112_716_599
        capital {
            name = "Cairo"
            population = 8_611_610
        }
    }

    val AUSTRALIA = buildCountry("AUS") {
        name = "Australia"
        region = AUSTRALIA_NEW_ZEALAND
        surface = 7_741_220.km2
        population = 26_439_112
        capital {
            name = "Canberra"
            population = 390_945
        }
    }

    val NEW_ZEALAND = buildCountry("NZL", "Nueva Zelanda") {
        region = AUSTRALIA_NEW_ZEALAND
        surface = 267_710.km2
        population = 5_228_100
        capital {
            name = "Wellington"
            population = 388_124
        }
    }


    val WORLD_COUNTRIES =
        listOf(
            SPAIN, RUSSIA, PORTUGAL, ITALY, GERMANY, FRANCE, UK, IRELAND,
            USA, MEXICO, CANADA, ARGENTINA, BRAZIL, VENEZUELA, COLOMBIA,
            CHINA, JAPAN, INDIA, TURKEY, INDONESIA, BANGLADESH,
            MOROCCO, NIGERIA, EGYPT,
            AUSTRALIA, NEW_ZEALAND
        )
}