Group3 Mini Project
===

Member
---

- Takayuki
- Miriam
- T.K(Takayasu)

System Design
---

**Player => Input => Piece => Movement => Board => Console**

Class / Interface
---

### Piece: abstract class

### King / Queen ... extend Piece

- boolean isWhite
- int value
- boolean isDead
- Position position


### Movement: Interface
- run()

### MacroMovement implement Movement
- ArryList<Movement> events
- run();
- push();
- undo();
- clear();

#### KingMovement / QueenMovement ... Implement Movement
- Board board
- Position
- run();
- movable()

### Board
- notify()
- どのマスにどのピースがある/ないかを管理

### Position

### Player
- ピースの移動を実行
- 何個ピースを持っているかを管理

### Game
- どちらのPlayerか管理

### Input
- ユーザーの入力を管理

### Validation


### Error

### Console

### Symbol

### Driver





