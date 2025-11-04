def call(String Project, String ImageTag, String DockerHubUser){
  echo "Pushing the image to DockerHub"
      withCredentials([usernamePassword(credentialsId: "DockerHubCred", 
                                        passwordVariable: "DockerHubPass", 
                                        usernameVariable: "DockerHubUser")]) {
          sh "docker login -u ${DockerHubUser} -p ${DockerHubPass}"
          
          sh "docker push ${DockerHubUser}/${Project}:${ImageTag}"
}
