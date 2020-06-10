pipeline {
  agent { label 'migration-6gb' }

  tools {
        maven 'apache-maven-latest'
        jdk 'oracle-jdk8-latest'
  }
  stages {
    stage('Package & test Kitalpha') {
      steps {
	  	wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
        	sh 'mvn  -Dmaven.test.failure.ignore=true -Dtycho.localArtifacts=ignore clean install  -e -f releng/plugins/org.polarsys.kitalpha.releng.parent/pom.xml'
        }
	  }
    }
    stage('SonarQube analysis') {
    	steps {
			//-Dsonar.auth.token=${SONAR_AUTH_TOKEN} -Dsonar.login=${SONAR_LOGIN} -Dsonar.password=${SONAR_PASSWORD} -Dsonar.jdbc.url=${SONAR_JDBC_URL} -Dsonar.jdbc.username=${SONAR_JDBC_USERNAME} -Dsonar.jdbc.password=${SONAR_JDBC_PASSWORD}  -Dsonar.login=$SONAR_UN -Dsonar.password=$SONAR_PW"
	  		wrap([$class: 'Xvnc', takeScreenshot: false, useXauthority: true]) {
          		sh '''
          			mvn -Dmaven.test.skip=true -Dsonar.host.url=https://sonar.eclipse.org/ -Dsonar.projectKey=org.polarsys:org.polarsys.kitalpha -Dsonar.jdbc.url=jdbc:mysql://dbmaster:3306/sonar?autoReconnect=true&useUnicode=true&characterEncoding=utf8 install sonar:sonar -PKitalphaSonar
          		'''
          	}
        }
    }
    stage('Deploy') {
      when {
         not { changeRequest() }
      }
      steps {
          sshagent ( ['projects-storage.eclipse.org-bot-ssh']) {
            sh '''
						echo "deploy update sites"
						DEST_DIR=/home/data/httpd/download.eclipse.org/kitalpha/updates/nightly
						VERSION=1.4.x
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/component/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/runtime/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/runtimecore/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}/sdk/${VERSION}
						
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/component/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/runtime/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/runtimecore/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}/sdk/${VERSION}
						
						scp -r releng/plugins/org.polarsys.kitalpha.releng.samplecomponent.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/component/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.runtime.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/runtime/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.runtime.core.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/runtimecore/${VERSION}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.sdk.updatesite/target/repository/* genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}/sdk/${VERSION}
						
						echo "deploy product"
						DEST_DIR=/home/data/httpd/download.eclipse.org/kitalpha/products/nightly/${VERSION}
						ssh genie.kitalpha@projects-storage.eclipse.org rm -rf ${DEST_DIR}
						ssh genie.kitalpha@projects-storage.eclipse.org mkdir -p ${DEST_DIR}
						scp -r releng/plugins/org.polarsys.kitalpha.releng.sdk.product/target/products/*.zip genie.kitalpha@projects-storage.eclipse.org:${DEST_DIR}
			  
            '''
          }
        }
      }
    }

  post {
    always {
	   archiveArtifacts artifacts: '**/*.log, **/*.layout, releng/plugins/org.polarsys.kitalpha.releng.samplecomponent.updatesite/target/repository/**, releng/plugins/org.polarsys.kitalpha.releng.runtime.core.updatesite/target/repository/**,releng/plugins/org.polarsys.kitalpha.releng.runtime.updatesite/target/repository/**,releng/plugins/org.polarsys.kitalpha.releng.sdk.updatesite/target/repository/**, releng/plugins/org.polarsys.kitalpha.releng.sdk.product/target/products/*.zip'
       junit '**/target/surefire-reports/*.xml'
    }
  }
}