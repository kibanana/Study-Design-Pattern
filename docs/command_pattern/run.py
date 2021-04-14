class Run:
    def startRunning(self):
        print("I'm running!")

class RunStartCommand:
    def __init__(self):
        self.theRunning = Run()
    def execute(self):
        self.theRunning.startRunning()