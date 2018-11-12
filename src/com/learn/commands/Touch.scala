package com.learn.commands
import com.learn.files.{DirEntry, File}
import com.learn.filesystem.State

class Touch(name: String) extends CreateEntry (name){

  override def createSpecificEntry(state: State): DirEntry =
    File.empty(state.wd.path, name)

}
