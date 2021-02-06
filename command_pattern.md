[https://anywayjhwa.tistory.com/11](https://anywayjhwa.tistory.com/11)

[https://gmlwjd9405.github.io/2018/07/07/command-pattern.html](https://gmlwjd9405.github.io/2018/07/07/command-pattern.html)

[https://www.zerocho.com/category/JavaScript/post/57c667f2ee0b9e9043fed696](https://www.zerocho.com/category/JavaScript/post/57c667f2ee0b9e9043fed696)

1. Command 패턴이란?

    > 커맨드 패턴(Command pattern)이란 요청을 객체의 형태로 **캡슐화**하여 사용자가 보낸 요청을 나중에 이용할 수 있도록 메서드 이름, 매개변수 등 요청에 필요한 정보를 저장 또는 로깅, 취소할 수 있게 하는 패턴

    - 출처 : 위키백과

    - Command : 명령, 지휘
    - 디자인패턴을 배울 때마다 항상 보는 단어가 **캡슐화**다. 매번 달라지는 부분을 클래스로 엮는데, 이번엔 요청(Command)이 바뀌어서 이 부분을 분리하는 패턴이다.
    - ex)

        고객사에게 리모컨의 API 디자인을 의뢰받았습니다. 각 버튼은 집 안의 선풍기, 에어컨, 거실 불, 부엌 불을 켜고 끄는 기능을 가지고 있고, 반드시 마지막에 작동했던 기능을 중지할 수 있는 Undo 기능이 있어야 한다고 합니다. 제어해야 하는 객체의 인터페이스 정보는 제공을 받은 상태입니다. 하지만 제공받은 기능들이 너무 제각각이라 한 인터페이스로 묶을 수 없는 상태입니다. 가령 TV라면 끄고 켜는 기능이 있을 것이고, 선풍기는 강 중 약으로 조절, 켜기, 끄기 등이 있겠죠?

        물론, 이에 대해 전부 리모컨에 기능별로 구현을 해도 지금 당장은 잘 동작할 것입니다. 물론 지금은 선풍기, TV, 거실, 부엌 방 불 정도가 전부이지만, 앞으로 제어해야 할 장치가 얼마나 더 늘어날지 모르는 일입니다. 이로 인해 수정 중에 버그가 발생할 수도 있고, 여러 코드를 고쳐야 하는 불상사가 생길 수 있겠죠. 어떻게 해야 가장 효율적인 방법으로 리모컨을 디자인할 수 있을까요?

    - 커맨드 패턴은 작업의 요청과 처리를 분리시키는 데 아주 좋은 패턴이다. 생각해보면, 굳이 리모컨이 어떠한 기능을 하는지 잘 알 필요가 없다. 요청을 처리하는 부분은 '요청이 발생했다'와 '요청이 발생하지 않았다'만 알면 되기 때문에 이를 분리시켜 보려고 한다.

    1. 커맨드 패턴 용어
        1. 수신자 `Receiver`

            행동을 하는 객체 → 제어 장치(할 수 있는 행동이 여러개 담겨 있을 것) → 장치

        2. 커맨드 `Command`

            수신자(Receiver)의 정보 + 행동이 들어 있는 객체 → 버튼의 행위

        3. 발동자 `Invoker`

            커맨드를 저장함 → 버튼이 어떤 행동을 할지 설정해주는 행위

        4. 클라이언트 `Client`

            커맨드 객체를 생성하고 발동자(Invoker)를 통해 수신자(Receiver)에게 할 행동을 전달함 → 리모컨

    2. 커맨드 패턴 동작 순서
        1. 클라이언트(Client)에서 커맨드 객체를 생성
        2. 발동자(Invoker)로 커맨드 객체를 저장
        3. 클라이언트(Client)에서 발동자(Invoker)를 통해 행동 요청을 전송
        4. 수신자(Receiver)가 행동함

    ![https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d9acde74-f069-46f4-a809-c30a972ea78e/Untitled.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d9acde74-f069-46f4-a809-c30a972ea78e/Untitled.png)

2. 코드 구현

    위는 통상적인 커맨드 패턴의 클래스 다이어그램. Client가 Receiver 정보와 함께 실행함수(`execute()`) 정보를 가지고 있는 커맨드 객체를 생성하고, 이 행위는 Invoker에 의해 설정되어서 요청이 왔을 때 실행이 되는 구조다.

    위에서는 여러 객체를 얘기했으나, 커맨드는 LightOn과 LightOff만 구현해보도록 하겠다.

    Light 리시버에 대한 구현

    - `CLight.h`

        ```csharp
        class CLight {
        public:
            CLight(char *lightLoc);
            ~CLight();
            void On();
            void Off();
         
        private:
            char mLightLocation[64];
        };
        ```

        Light는 거실 불이 될 수도 있고, 부엌 불이 될 수도 있기 때문에 `mLightLocation` 변수에 장소 이름을 저장시켜 놓습니다. 리시버 생성시 위치에 대한 정보를 담을 수 있도록 생성자에 위치 이름을 붙여야 하게 구현하였습니다.

    - `CLight.cpp`

        ```csharp
        CLight::CLight(char *lightLoc)
        {
            strcpy(mLightLocation ,lightLoc);
        }
         
        void CLight::On() {
            printf("%s Light is On\n", mLightLocation);
        }
         
        void CLight::Off(){
            printf("%s Light is Off\n", mLightLocation);
        }
        ```

        구현부는 특별히 볼 내용이 없습니다. On 함수 적용시 해당 위치의 Light가 켜지고, 꺼진다는 내용이 적혀 있습니다.

    - `CCommand.h`

        ```csharp
        class CCommand {
        public:
            CCommand();
            virtual void Execute() = 0;
            virtual void Undo() = 0;
        public:
            char mCommandName[256];
        };
        ```

        기본 Command 인터페이스입니다.

        기본적으로 커맨드 객체는 `Execute()`를 가지고 있어야 하고, 위에서 리모컨의 `Undo()` 기능이 있어야 한다고 했기 때문에, 이를 가상함수로 구현해 놓았습니다. 그리고 나중에 해당 커맨드의 이름을 알고 싶어 command 이름을 상속시킬 수 있게 커맨드 클래스에 구현 해놓았습니다.

    - `CLightOnCommand.h`

        ```csharp
        class CLightOnCommand : public CCommand{
         
        private:
            CLight *mLight;
         
        public:
            CLightOnCommand();
            void Execute();
            void LightOnCommand(CLight *light);
            void Undo();
        };
        ```

        `Command` 인터페이스를 상속받은 `LightOnCommand`입니다.

        `Command` 객체에는 Receiver 정보와 행동정보가 있는데, 행동 정보는 `Execute`에 구현되어 있습니다. 그리고 Receiver인 `mLight` 가 있는 것을 확인하실 수 있습니다.

    - `CLightOnCommand.cpp`

        ```csharp
        CLightOnCommand::CLightOnCommand()
        {
            strcpy(mCommandName, "Light On Command");
        }
         
        void CLightOnCommand::LightOnCommand(CLight *light)
        {
            mLight = light;
        }
         
        void CLightOnCommand::Execute()
        {
            mLight->On();
        }
         
        void CLightOnCommand::Undo()
        {
            mLight->Off();
        }
        ```

        `LightOnCommand`을 통해 Receiver 정보를 기록하고, `LightOn` 요청이기 때문에 `Execute()` 에는 해당 리시버의 `On()` 행동을 담고 있습니다. `Undo()` 에선 해당 행동을 revert 시켜야 하기 때문에 반대 행동 정보를 가지고 있습니다.

    - `CLightOffCommand.h`

        ```csharp
        class CLightOffCommand : public CCommand{
         
        private:
            CLight *mLight;
         
        public:
            CLightOffCommand();
            void Execute();
            void LightOffCommand(CLight *light);
            void Undo();
        };
        ```

    - `CLightOffCommand.cpp`

        ```csharp
        CLightOffCommand::CLightOffCommand()
        {
            strcpy(mCommandName, "Light Off Command");
        }
         
        void CLightOffCommand::LightOffCommand(CLight *light) {
            mLight = light;
        }
         
        void CLightOffCommand::Execute()
        {
            mLight->Off();
        }
         
        void CLightOffCommand::Undo()
        {
            mLight->On();
        }
        ```

    이번엔 리모컨에 대한 구현입니다.

    리모컨엔 각 슬롯이 있고, 슬롯에 명령을 할당시키는 방식으로 구현하였습니다.

    - `CRemoteControl.h`

        ```csharp
        class CRemoteControl {
         
        private:
            int mNumCommand;
            CCommand** mOnCommand;
            CCommand** mOffCommand;
            stack<CCommand *> mCurCmdList;
         
        public:
            CRemoteControl(int numCmd);
            void PrintCurCommandList();
            void SetCommand(int slotIdx, CCommand *onCommand, CCommand *offCommand);
            void OnButtonClicked(int slotIdx);
            void OffButtonClicked(int slotIdx);
            void Undo();
         
        private:
            void InitRemoteCtrl();
         
        };
        ```

        슬롯의 개수를 유동적이게 할 수 있도록 구현 해 놓았습니다. 생성자에서 넣는 파라미터 값이 슬롯의 개수가 되도록 만들어 놓았습니다.

        `SetCommand()` Invoker를 통해 각 슬롯이 어떤 행동을 하게 만들지 지정하고, 각 슬롯의 버튼을 클릭 했을 때 미리 슬롯에 지정해 놓은 Command를 실행할 수 있도록 구조를 만들어 놓았습니다.

        그리고 클라이언트에서 마지막에 어떤 일을 했는지 알아야 `Undo()`를 할 수 있으니 마지막에 어떤 행동을 했는지 저장하기 위해 행동한 커맨드의 포인터를 저장한  `mCurCmdList` 스택 변수도 선언해 놓았습니다.

    - `CRemoteControl.cpp`

        ```csharp
        CRemoteControl::CRemoteControl(int numCmd)
        {
            mOnCommand = (CCommand **)malloc(sizeof(CCommand*) * numCmd);
            mOffCommand = (CCommand **)malloc(sizeof(CCommand*) * numCmd);
         
            mNumCommand = numCmd;
         
            InitRemoteCtrl();
        }
         
        void CRemoteControl::InitRemoteCtrl() {
         
            for(int i = 0; i < mNumCommand; i++)
            {
                CNoCommand *noOnCommand = new CNoCommand();
                CNoCommand *noOffCommand = new CNoCommand();
         
                mOnCommand[i] = noOnCommand;
                mOffCommand[i] = noOffCommand;
            }
         
        }
         
        void CRemoteControl::PrintCurCommandList() {
         
            printf("----------- Current Command List -----------\n");
            for(int i = 0; i < mNumCommand; i++)
            {
                printf("OnCommand  %d's button : %s \n", i + 1,mOnCommand[i]->mCommandName);
                printf("OffCommand %d's button : %s \n", i + 1, mOffCommand[i]->mCommandName);
            }
            printf("--------------------------------------------\n\n");
        }
         
        void CRemoteControl::SetCommand(int slotIdx, CCommand *onCommand, CCommand *offCommand)
        {
            if(mOnCommand[slotIdx])
            {
                free(mOnCommand[slotIdx]);
            }
         
            if(mOffCommand[slotIdx])
            {
                free(mOffCommand[slotIdx]);
            }
         
            mOnCommand[slotIdx] = onCommand;
            mOffCommand[slotIdx] = offCommand;
        }
         
        void CRemoteControl::OnButtonClicked(int slotIdx) {
            mCurCmdList.push(mOnCommand[slotIdx]);
            mOnCommand[slotIdx]->Execute();
        }
         
        void CRemoteControl::OffButtonClicked(int slotIdx) {
            mCurCmdList.push(mOffCommand[slotIdx]);
            mOffCommand[slotIdx]->Execute();
        }
         
        void CRemoteControl::Undo()
        {
            CCommand *cmd = mCurCmdList.top();
            cmd->Undo();
            mCurCmdList.pop();
        }
        ```

        RemoteControl 생성시 슬롯 개수만큼 동적으로 할당해 주고, 처음 버튼에 아무런 행동을 하지 않는 `Command` 객체를 할당하여 줍니다.

        `SetCommand()`를 통해 각 슬롯의 On, Off시 동작을 붙이도록 해 놓았고, `OnButtonClicked()` , `OffButtonClicked()` 동작시 버튼에 할당된 행동이 동작하게 되고, 행동에 대한 포인터를 동작시 저장해서 스택에 쌓을 수 있게 해 놓았습니다.

        그리고, `Undo()` 작동시 마지막에 동작한 `Command`의 `Undo` 함수를 실행시키고, `pop`을 이용하여 `Undo`를 하였으니 이전 행동을 제거합니다.

    - `main.cpp`

        ```csharp
        int main() {
         
            CRemoteControl *remoteCtrl = new CRemoteControl(7);
            remoteCtrl->PrintCurCommandList();
         
            CLight *livingRoomLight = new CLight("Living Room");
            CLightOnCommand *livLightOnCmd = new CLightOnCommand();
            CLightOffCommand *livLightOffCmd = new CLightOffCommand();
         
            CLight *kitchenLight = new CLight("Kitchen Room");
            CLightOnCommand *kitLightOnCmd = new CLightOnCommand();
            CLightOffCommand *kitLightOffCmd = new CLightOffCommand();
         
            livLightOnCmd->LightOnCommand(livingRoomLight);
            livLightOffCmd->LightOffCommand(livingRoomLight);
         
            kitLightOnCmd->LightOnCommand(kitchenLight);
            kitLightOffCmd->LightOffCommand(kitchenLight);
         
            remoteCtrl->SetCommand(0, (CCommand *)livLightOnCmd, (CCommand *)livLightOffCmd);
            remoteCtrl->SetCommand(1, (CCommand *)kitLightOnCmd, (CCommand *)kitLightOffCmd);
            
            remoteCtrl->PrintCurCommandList();
         
            remoteCtrl->OnButtonClicked(0);
            remoteCtrl->OffButtonClicked(0);
         
            remoteCtrl->OnButtonClicked(1);
            remoteCtrl->OffButtonClicked(1);
         
            remoteCtrl->Undo();
        }
        ```

3. 정리
    1. 장점

        커맨드 패턴을 활용하도록 요청부와 동작부를 분리시켜주기 때문에 시스템 결합도를 낮출 수 있으며, 각 객체들이 수정되어도 다른 객체가 영향을 받지 않는다.

    2. 단점

        하지만 리시버의 동작이 추가된다면 그 동작에 대한 클래스를 만들어야 하기 때문에 다소 많은 잡다한 클래스들이 추가된다는 단점이 있다.

    3. 활용
        - 작업큐

            커맨드 리스트를 작업 큐에 저장한 후, 스레드는 큐로부터 커맨드를 하나씩 받아서 각 work의 `Execute()`만 수행하면 된다.

        - 로그 기록

            디스크에 실행 히스토리를 기록한다.

            애플리케이션이 다운되었을 경우 커맨드 객체를 다시 로드하여 `Execute()`만 실행하면 된다.
