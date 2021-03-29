kubectl apply -f platform/platform-admin-server.yml
kubectl apply -f platform/platform-gateway-server.yml

kubectl apply -f service/demo-service.yml
kubectl apply -f service/demo-service-b.yml
