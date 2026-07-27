import React, { useState } from 'react';

function BookDetails() {
  return <h3>Book Details: React for Beginners</h3>;
}
function BlogDetails() {
  return <h3>Blog Details: How to use Hooks</h3>;
}
function CourseDetails() {
  return <h3>Course Details: React Advanced</h3>;
}

function App() {
  const [selected, setSelected] = useState('book');
  const renderComponent = () => {
    if (selected === 'book') return <BookDetails />;
    else if (selected === 'blog') return <BlogDetails />;
    else if (selected === 'course') return <CourseDetails />;
    else return <div>Select an option</div>;
  };

  return (
    <div>
      <button onClick={() => setSelected('book')}>Book</button>
      <button onClick={() => setSelected('blog')}>Blog</button>
      <button onClick={() => setSelected('course')}>Course</button>
      {renderComponent()}
    </div>
  );
}

export default App;
