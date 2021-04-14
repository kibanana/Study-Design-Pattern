# main

from button import Button
from run import Run, RunStartCommand
from walk import Walk, WalkStartCommand

run=Run()
runStartCommand=RunStartCommand()
walk=Walk()
walkStartCommand=WalkStartCommand()

button_run=Button(runStartCommand)
button_walk=Button(walkStartCommand)

button_run.pressed()
button_walk.pressed()