#!/bin/bash
folders=$(find . -maxdepth 1 -type d -regex './[0-9]+-[^/]*' -printf "%f\n")
sorted_folders=$(echo "$folders" | sort -t '-' -k1n)
links=""
for folder in $sorted_folders; do
    link="[${folder}](./${folder})"
    links="$links\n- $link"
done

# Create new README content
readme_content="# LeetCode Submissions\n\n\
![Generate Readme Workflow](https://github.com/jashgopani/leetcode/actions/workflows/main.yml/badge.svg)\n\
## Index\n\n\
$links\n\
---\n"

# Overwrite README.md with new content
echo -e "$readme_content" > README.md
echo "**Last Updated**: $(date +"%Y-%m-%d %H:%M:%S")" >> README.md
