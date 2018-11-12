package com.learn.commands
import com.learn.filesystem.State

class Pwd extends Command {

  override def apply(state: State): State =
    state.setMessage(state.wd.path)

}
