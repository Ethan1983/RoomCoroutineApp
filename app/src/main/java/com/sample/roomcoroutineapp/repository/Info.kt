package com.sample.roomcoroutineapp.repository

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Info ( @PrimaryKey val name : String )