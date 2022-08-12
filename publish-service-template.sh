#! /bin/bash -e

export ROOT=$(pwd)

export THE_DIR="${ROOT}/build/published-service-template"

if [ ! -d "$THE_DIR" ] ; then
  git worktree add -B published-service-template $THE_DIR origin/published-service-template
fi

cd $THE_DIR

git reset --hard origin/published-service-template
git pull

rm -fr .gitignore [_a-zA-Z0-9]*

cp -r $ROOT/service-template/* .

rm -fr service-chassis-*

sed -i.bak -e '/service-chassis/d' -e "s?^.*MAVEN_REPO_URL.*\$?          url = uri(\"https://maven.pkg.github.com/${GITHUB_REPOSITORY?}\")?" settings.gradle.kts
rm *.bak

cp -r $ROOT/.gitignore $ROOT/dot.testcontainers.properties .

#./gradlew compileAll

git add .

git diff-index --quiet HEAD || git commit -am "Updated"

git push
