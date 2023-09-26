echo "Starting to deploy docker image.."
DOCKER_IMAGE=sudhirkr92/hackthon-23:latest
docker pull $DOCKER_IMAGE
docker ps -q --filter ancestor=$DOCKER_IMAGE | xargs -r docker stop
docker run -d -p 8085:8085 -p 8087:8088 $DOCKER_IMAGE