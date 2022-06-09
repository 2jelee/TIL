import React from 'react';
import  ReactPlayer  from  'react-player'

function Video_Home() {
    return (
        <>
            {/*<video width="auto" height="auto" autoPlay>*/}
            {/*    <source src="vv" type="" />*/}
            {/*</video>*/}
            {/*</video>*/}
            <ReactPlayer
                url='https://f-data1-42.wecandeo.com/100/858/100-141202858-793d.mp4?_metahint_fn=/100/507/2022/04/29/15/V25931499.mp4&key=0RKuGQK8wy+inpnLVdnELf8HlJiKvJzADKb+OK5XUuCaIXheiUujVIZ1DHFHE8icCoEyQwaK+naesuMotD6Naf8lETLi7xWd4F4ZehHUe1I=&packageId=1017727&videoId=13287131'
                playing={true} loop={true}
            />
        </>
    );
}

export default Video_Home;