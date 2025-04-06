#!/bin/bash

echo "🛑 [$(date)] 기존 'blue' 컨테이너 중지 시도"
sudo docker stop blue && \
echo "✅ [$(date)] 'blue' 컨테이너 중지 성공" || \
echo "⚠️ [$(date)] 중지할 'blue' 컨테이너가 없거나 이미 중지됨"

echo "🗑️ [$(date)] 기존 'blue' 컨테이너 삭제 시도"
sudo docker rm blue && \
echo "✅ [$(date)] 'blue' 컨테이너 삭제 성공" || \
echo "⚠️ [$(date)] 삭제할 'blue' 컨테이너가 없거나 이미 삭제됨"
