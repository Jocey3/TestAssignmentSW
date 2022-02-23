package com.dev.jocey.utils.entityes

interface Mapper<A, B> {
    fun mapFrom(a: A): B
}