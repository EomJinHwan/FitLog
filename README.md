# Auth & Exercise API v1

## 작업 개요

FitLog 1차 기능으로 회원가입/로그인, JWT 발급, 운동 종목 등록/조회/삭제 API를 구현했습니다.

## 구현 기능

- User Entity 설계
- Exercise Entity 설계
- 회원가입 API 구현
- 로그인 API 구현
- BCrypt 비밀번호 암호화
- JWT Access Token 발급
- JWT 인증 필터 추가
- Exercise 등록/조회/삭제 API 구현
- ExerciseType, ExercisePart Enum 적용

## API

| Method | URL | 설명 |
|---|---|---|
| POST | `/api/auth/signup` | 회원가입 |
| POST | `/api/auth/login` | 로그인 |
| POST | `/api/exercises` | 운동 종목 등록 |
| GET | `/api/exercises` | 운동 종목 전체 조회 |
| DELETE | `/api/exercises/{exerciseNo}` | 운동 종목 삭제 |

## 다음 작업
- SecurityConfig 인증/인가 적용
- WorkoutLog Entity 설계
