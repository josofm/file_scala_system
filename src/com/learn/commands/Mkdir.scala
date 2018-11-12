package com.learn.commands
import com.learn.files.{DirEntry, Directory}
import com.learn.filesystem.State

class Mkdir (name: String) extends CreateEntry(name) {

  override def createSpecificEntry(state: State): DirEntry =
    Directory.empty(state.wd.path, name)


}
