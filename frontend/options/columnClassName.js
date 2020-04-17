function createClassNameObject(columnName) {
  return {
    plusButton: `${columnName}_plus`,
    addButton: `${columnName}_add_btn`,
    cancelButton: `${columnName}_cancel_btn`,
  };
}

export default createClassNameObject;
