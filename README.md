# Workout Log API v1

## 작업 개요

FitLog 2차 기능으로 JWT 기반 내 정보 조회와 운동 기록 등록/조회 API를 구현했습니다.

## 구현 기능

- SecurityConfig 인증 URL 설정
- WorkoutLog Entity 설계
- WorkoutExercise Entity 설계
- WorkoutSet Entity 설계
- JPA 연관관계 설정
- 운동 기록 등록 API 구현
- 내 운동 기록 목록 조회 API 구현

## API

| Method | URL | 설명 |
|---|---|---|
| POST | `/api/workouts` | 운동 기록 등록 |
| GET | `/api/workouts` | 내 운동 기록 목록 조회 |

## 다음 작업

- 운동 기록 상세 조회
- 운동 기록 수정/삭제
- 날짜별 운동 기록 조회
- 월별 운동 기록 조회
