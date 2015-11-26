#! /usr/bin/env bash

echo "Enter the new package name (e.g. com.example.app):"
read package_name
if [ "$package_name" == "" ]; then
  echo "You need to enter an input package name"
  exit
fi
echo "The new project package name will be: $package_name"

sed -i.bak 's/com.fsstudio.template/'"$package_name"'/g' app/build.gradle

# Remove all .DS_Store files
find . -name '*.DS_Store' -type f -delete
# Rename all files
find ./app/src/main/java -type f -name "*.java" -exec sed -i.bak 's/com.fsstudio.template/'"$package_name"'/g' {} +
find ./app/src/main -type f -name "*.xml" -exec sed -i.bak 's/com.fsstudio.template/'"$package_name"'/g' {} +

# Split package name
package_name_arr=(${package_name//./ })

mv -f ./app/src/main/java/com/fsstudio/template ./app/src/main/java/com/fsstudio/${package_name_arr[2]} 2>/dev/null; true
mv -f ./app/src/main/java/com/fsstudio ./app/src/main/java/com/${package_name_arr[1]} 2>/dev/null; true
mv -f ./app/src/main/java/com ./app/src/main/java/${package_name_arr[0]} 2>/dev/null; true

# Remove all .bak files
find . -name '*.bak' -type f -delete
