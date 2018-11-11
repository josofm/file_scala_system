package com.learn.commands

import com.learn.filesystem.State

trait Command {

  def apply(state: State): State

}

object Command {


  def from(input: String): Command =
    new UnkownCommand
}
