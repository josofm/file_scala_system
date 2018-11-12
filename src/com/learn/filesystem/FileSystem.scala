package com.learn.filesystem

import java.util.Scanner

import com.learn.commands.Command
import com.learn.files.Directory


object FileSystem extends App {

  val root = Directory.ROOT

// TODO work this
//  io.Source.stdin.getLines().foldLeft(State(root, root))((currentState, newLine) => {
//    currentState.show
//    Command.from(newLine).apply(currentState)
//  })

  var state =  State(root, root)
  val scanner = new Scanner(System.in)

  while (true) {
    state.show
    val input = scanner.nextLine()
    state = Command.from(input).apply(state)
  }

}
