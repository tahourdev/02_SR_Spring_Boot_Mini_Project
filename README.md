# Git Workflow Summary Script

# 1. Clone the repository (first time only)
git clone <repository-url>
cd <repository-name>

# 2. Update local main branch
git checkout main
git pull origin main

# 3. Create and switch to your own branch (replace 'your-name' with your actual name)
git checkout -b your-name

# 4. Work on your code, then stage and commit changes
git add .                               # Or specify files instead of '.'
git commit -m "Describe your changes"

# 5. Push your branch to remote
git push origin your-name

# 6. (Optional) Sync your branch with updated main
git checkout main
git pull origin main
git checkout your-name
git merge main

# 7. After pushing, go to GitHub/GitLab to create a Pull Request from your-name branch to main
