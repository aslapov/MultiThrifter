package com.multithrifter.core.mapper

interface Mapper<FROM, TO> {
    fun map(from: FROM): TO
}