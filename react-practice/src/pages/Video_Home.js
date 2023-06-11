import React from 'react';
import ReactPlayer  from  'react-player'

function Video_Home() {
    return (
        <>
            <ReactPlayer
               // playing='true'
               url='https://www.youtube.com/watch?v=P1blJP2T7Tg'
               width='auto'
               muted='false'
               // playIcon='false'
               // controls='false'
            />
        </>
    );
}

export default Video_Home;