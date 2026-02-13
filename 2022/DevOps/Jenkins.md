# 설치 (Mac)
```
brew install jenkins
```

## 젠킨스 시작
```
brew services start jenkins
```

## 젠킨스 종료
```
brew services stop jenkins
```

## 젠킨스 재시작
```
brew services restart jenkins
```

### 접속 포트 변경
```
vi (jenkins가 설치된 경로)/jenkins/(jenkins 설치version)/homebrew.mxcl.jenkins.plist
```

`
<string>--httpPort=XXXX</string>
`
을 원하는 포트로 변경
