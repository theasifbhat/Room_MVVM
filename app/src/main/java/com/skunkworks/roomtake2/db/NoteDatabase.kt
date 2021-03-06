package com.skunkworks.roomtake2.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Note::class],version = 1,exportSchema = false)
abstract class NoteDatabase :RoomDatabase() {

  abstract fun noteDao():NoteDao

  companion object{
      @Volatile
      private var INSTANCE : NoteDatabase?= null

      fun getDatabase(context: Context) : NoteDatabase{
          val temp= INSTANCE
          if (temp!=null)
              return temp
          else{
              synchronized(this){
                  val instance = Room.databaseBuilder(
                      context.applicationContext, NoteDatabase::class.java,
                      "word_database"
                  ).build()
                  INSTANCE = instance
                  return instance
              }

          }


      }


}

}