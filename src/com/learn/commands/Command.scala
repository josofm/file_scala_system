package com.learn.commands

import com.learn.filesystem.State

trait Command extends (State => State)

object Command {

  val MKDIR = "mkdir"
  val LS = "ls"
  val PWD = "pwd"
  val TOUCH = "touch"
  val CD = "cd"
  val RM = "rm"
  val ECHO = "echo"
  val CAT = "cat"

  def emptyCommand: Command = new Command {
    override def apply(state: State): State = state
  }
  def incompletCommand(name: String): Command = new Command {
    override def apply(state: State): State =
      state.setMessage(name + ": incomplete command!")
  }

  def from(input: String): Command = {
    val tokens: Array[String] = input.split(" ")
    if (input.isEmpty || tokens.isEmpty) emptyCommand
    else tokens(0) match {
      case MKDIR =>
        if (tokens.length < 2) incompletCommand(MKDIR)
        else new Mkdir(tokens(1))

      case LS =>
        new Ls

      case PWD =>
        new Pwd

      case TOUCH =>
        if (tokens.length < 2) incompletCommand(TOUCH)
        else new Touch(tokens(1))

      case CD =>
        if (tokens.length < 2) incompletCommand(CD)
        else new Cd(tokens(1))

      case RM =>
        if (tokens.length < 2) incompletCommand(CD)
        else new Rm(tokens(1))

      case ECHO =>
        if (tokens.length < 2) incompletCommand(ECHO)
        else new Echo(tokens.tail)

      case CAT =>
        if (tokens.length < 2) incompletCommand(CAT)
        else new Cat(tokens(1))

      case _ =>
        new UnkownCommand
    }

  }


}
