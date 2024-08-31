#!/bin/bash

# 클러스터 이름 지정
CLUSTER_NAME="microservices"

# Kind 클러스터 삭제 명령어 실행
kind delete cluster --name $CLUSTER_NAME

echo "Kind 클러스터 '$CLUSTER_NAME'가 삭제되었습니다."