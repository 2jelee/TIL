아마존이 운영하는 웹 서비스인 AWS에 window 서버를 구축하고 tomcat을 깔아본다.
원격서버에 톰캣을 설치하고 컴터 웹 브라우저로 원격서버 톰캣에 접속해본다.
cloud service >> cloud computing << cloud : internet을 의미

Amazon이 제공하는 cloud service.
관리가 쉽고 빠르고 유연한 확장성이 장점. 보안. 필요할 때만 사용하고, 사용한 만큼만 비용지불
보안 또한 관리해주므로 비용 ↓  

Amazon EC2 - 크기 조정이 가능한 컴퓨팅 용량을 클라우드에서 제공하는 웹 서비스
ㄴ 웹호스팅에 해당
VM(Virtual Machine ; 가상 컴퓨터) >> "instance" 하나가 만들어짐 << 여기에 windows, tomcat을 설치

S3 Simple Storage Service 데이터 저장공간을 서비스함. 단순한 저장공간이 X 
확장성(필요하면 더 많이 쓸 수 O), 가용성(저장공간을 여러 서버에서 같이 공유할 수 있는), 내구성 (데이터가 깨지거나 그러면 복구해줌)
simple이 3개라 S3

RDS (Relational DataBase Service) >> 관계형 DB관리 서비스, 모니터링(메모리, 성능 등을), 주기적 백업

  on-Premise : 서버를 직접 운영하는 방식    << 직접? 관리자 필요 | 회사에 가지고 있거나, IDC를 이용
  Serverless : 서버 작업을 서버내부가 아닌 '클라우드 서비스'로 처리   << 최근 추세 (S3나 RDS << 클라우드 서비스)
  Region : 데이터 센터가 '물리적'으로 존재하는 곳. (ex. 서울 Region) 
  CDN(Content Delivery Network) : 정적 리소스를 빠르게 제공할 수 있게 전세계의 캐시서버에 복제해주는 서비스.

※ instance : 가상 컴퓨터를 하나 새로 만든 것!
