import os

def guardar(content, file_path):
  """Saves content to a file at the specified path.

  Args:
      content: The string content to be saved.
      file_path: The path to the file where the content will be saved.
  """

  try:
    
    # Create the file if it doesn't exist
    if not os.path.exists(file_path):
      os.makedirs(os.path.dirname(file_path), exist_ok=True)  # Create directories if needed
      with open(file_path, 'w') as f:
        pass  # Create an empty file

    # Append content to the file
    with open(file_path, 'a') as f:
      f.write(content + "\n")

  except IOError as e:
    print(f"Error saving file: {e}")

def get_path(file_path):
  """Gets the full path to the file by combining the current directory with the provided path.

  Args:
      file_path: The relative path to the file.

  Returns:
      The absolute path to the file.
  """

  current_dir = os.getcwd()
  return os.path.join(current_dir, file_path)