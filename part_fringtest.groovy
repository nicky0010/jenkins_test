properties([
    parameters([
		string(name: 'brEdfBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		string(name: 'brEdfultilsBranch', defaultValue: 'support/v1.0', description: 'github target branch'),
		[
			$class      : 'ChoiceParameter',
			choiceType  : 'PT_CHECKBOX',
			description : 'target deploy component',
			filterLength: 1,
			filterable  : true,
			name        : 'components',
			script      : [
				$class        : 'GroovyScript',
				fallbackScript: [
					classpath: [],
					sandbox  : false,
					script   : 'return ["ERROR"]'
				],
				script        : [
					classpath: [],
					sandbox  : false,
					script   : 'return[\'fr-edf\',\'fr-edf-utils\']'
				]
			]
		],
	])
])

pipeline {
	agent any
	stages {
		stage('Publish') {
			steps {
				script {
					echo "${workspace}"
					echo "${pwd()}"
					commonProperties = readYaml file: "${pwd()}@script/jenkinsfiles/nicky-artifact/envs/common.yml"
					props = commonProperties.props
					mavenSetting = "${pwd()}@script/${props.mavenSettingXmlPath}"
				}
			}
		}
	}
}
