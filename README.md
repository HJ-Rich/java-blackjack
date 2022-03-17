<p align="center">
    <img src="./woowacourse.png" alt="우아한테크코스" width="250px">
</p>

# 블랙잭 - 상속, 인터페이스

---

![Generic badge](https://img.shields.io/badge/Level2-blackjack-green.svg)
![Generic badge](https://img.shields.io/badge/test-32_passed-blue.svg)
![Generic badge](https://img.shields.io/badge/version-2.0.0-brightgreen.svg)

> 우아한테크코스 웹 백엔드 4기, 블랙잭 - 상속, 인터페이스 저장소입니다.

<img src="./blackjack-step1-operation.gif" alt="java-blackjack-operation" width="400px">

<br><br>

## 기능 구현 목록

---

### 플레이어

- [x] 이름을 입력 받아 플레이어를 생성한다
- [x] 딜러를 생성한다
- [x] 플레이어에게 카드를 지급한다
- [x] 딜러는 16 이하일 시 카드를 계속해서 더 받는다
- [x] 메시지를 받아 버스트 여부를 반환한다
- [x] 메시지를 받아 현재 점수를 반환한다
- [x] 메시지를 받아 카드 보유 상태와 결과를 반환한다

### 카드

- [x] 문양과 숫자로 카드를 생성한다

### 플레이어 묶음

- [x] 플레이어 묶음에 요청을 전하면 결과를 반환한다

### 카드덱

- [x] 카드를 랜덤하게 섞은 카드 덱을 생성한다

### 입력

- [x] 쉼표로 분리된 플레이어 이름을 입력받는다
    - [예외처리] null 또는 빈값 입력시 예외를 발생시킨다
    - [예외처리] 중복된 이름 입력시 예외를 발생시킨다
- [x] 각 플레이어별로 카드를 계속 뽑을지 여부에 대해 예는 y, 아니오는 n로 입력받는다
    - [예외처리] null 또는 빈값 입력시 예외를 발생시킨다
    - [예외처리] y나 n이 아닌 입력에 대해 예외를 발생시킨다

### 출력

- [x] 입력받은 플레이어 이름을 출력한다
- [x] 딜러와 플레이어들의 최초 지급된 카드들을 출력한다
- [x] 카드를 계속 뽑을지 여부와 현재 소지한 카드를 출력한다
- [x] 게임 종료시 각 플레이어별 결과를 출력한다
- [x] 최종 승패를 출력한다

## 실행 결과

```
게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)
pobi,jason

딜러와 pobi, jason에게 2장의 나누었습니다.
딜러: 3다이아몬드
pobi카드: 2하트, 8스페이드
jason카드: 7클로버, K스페이드

pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
y
pobi카드: 2하트, 8스페이드, A클로버
pobi는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason은 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)
n
jason카드: 7클로버, K스페이드

딜러는 16이하라 한장의 카드를 더 받았습니다.

딜러 카드: 3다이아몬드, 9클로버, 8다이아몬드 - 결과: 20
pobi카드: 2하트, 8스페이드, A클로버 - 결과: 21
jason카드: 7클로버, K스페이드 - 결과: 17

## 최종 승패
딜러: 1승 1패
pobi: 승
jason: 패
```

<br><br>
