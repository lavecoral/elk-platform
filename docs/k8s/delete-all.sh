kubectl delete -f platform/platform-admin-server.yml
kubectl delete -f platform/platform-gateway-server.yml

kubectl delete -f service/demo-service.yml
kubectl delete -f service/demo-service-b.yml
