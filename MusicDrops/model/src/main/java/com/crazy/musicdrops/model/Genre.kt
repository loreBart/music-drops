package com.crazy.musicdrops.model

enum class Genre {
    UNKNOWN,
    ALTERNATIVE,
    ANIME,
    BLUES,
    CLASSICAL,
    COMMERCIAL,
    COUNTRY,
    DANCE,
    ELECTRONIC,
    FOLK,
    HIP_HOP,
    LATIN,
    METAL,
    NEW_AGE,
    OPERA,
    POP,
    REGGAE,
    SOUL,
    ROCK,
    JAZZ;

    companion object {
        fun fromInt(genre: Int): Genre = values()[genre]
    }
}

