class Button:
    def __init__(self, command):
        self.theCommand = command
    def pressed(self):
        self.theCommand.execute()