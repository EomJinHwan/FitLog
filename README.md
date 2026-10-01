# Workout Query API

## 작업 개요

FitLog 3차 기능으로 운동 기록 상세 조회, 삭제, 날짜별 조회, 월별 조회 기능을 구현했습니다.

JWT 인증 정보를 기반으로 로그인 사용자를 확인하고,
운동 기록 상세 조회와 삭제 시 해당 기록의 소유자인지 검증하도록 구현했습니다.

## 구현 기능

- 운동 기록 상세 조회 API 구현
- 로그인 사용자와 운동 기록 소유자 검증
- WorkoutDetailResponse를 이용한 상세 응답 DTO 구성
- 운동 기록 삭제 API 구현
- WorkoutLog 삭제 시 연관된 WorkoutExercise, WorkoutSet 함께 삭제
- 날짜별 운동 기록 조회 API 구현
- 월별 운동 기록 조회 API 구현
- 사용자 + 날짜 조건 기반 Repository 조회 메서드 추가
- 날짜 범위를 이용한 월별 기록 조회 구현

## API

| Method | URL | 설명 |
|---|---|---|
| GET | `/api/workouts/{workoutLogNo}` | 내 운동 기록 상세 조회 |
| DELETE | `/api/workouts/{workoutLogNo}` | 내 운동 기록 삭제 |
| GET | `/api/workouts/date?workoutDate=YYYY-MM-DD` | 날짜별 운동 기록 조회 |
| GET | `/api/workouts/month?year=YYYY&month=MM` | 월별 운동 기록 조회 |

## 주요 구현 내용

### 운동 기록 소유자 검증

운동 기록은 사용자별 개인 데이터이기 때문에
상세 조회 및 삭제 전에 로그인 사용자와 운동 기록의 소유자가 같은지 확인하도록 구현했습니다.

```java
if (!user.getUserNo().equals(workoutLog.getUser().getUserNo())) {
    throw new IllegalArgumentException("해당 운동 기록에 접근할 수 없습니다");
}
