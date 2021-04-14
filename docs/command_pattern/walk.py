class Walk:
    def startWalking(self):
        print("I'm walking!")

class WalkStartCommand:
    def __init__(self):
        self.theWalking = Walk()
    def execute(self):
        self.theWalking.startWalking()