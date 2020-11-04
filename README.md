Group3 Mini Project
===

Member
---

- Taka(Takayuki)
- Miriam
- Yasu(Takayasu)

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
- ArryList<Movement> movements
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

### Player
- ピースの移動を実行
- 何個ピースを持っているかを管理

### Game
- どちらのPlayerか管理

### Input
- ユーザーの入力を管理

### Validation

### Console

### Symbol

### Driver





